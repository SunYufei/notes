---
lastUpdated: 2019-03-06
---

# Windows 下 OpenCV 安装踩坑记

> 你已经是一台成熟的电脑了，该学会自己给自己安装开发环境了。

## 前言

项目需要使用 OpenCV 和它的扩展模块 opencv_contrib，官网上只提供源码、不含扩展模块的 Windows 版本、iOS 和 Android pack，想使用 OpenCV 和它的扩展模块，有如下的几种方法：

1. 使用 OpenCV Python 接口
2. 使用 Manjaro Linux / Arch Linux 系统并安装 OpenCV
3. 下载源码自行编译
4. 其他方法

## 0x01

先来说说第一种方法，安装很简单：

```sh
pip install opencv-python opencv-contrib-python
```

使用方法参考官方文档即可，前面一直用这个方法，开发很快也很顺利。

**「一号坑已就位」**

OpenCV 基础模块用到现在没发现什么问题，直到我用到了扩展模块中的 face 模块，按照官方文档的要求写好程序，运行时发生了程序卡死的现象。搜了一下在 GitHub 上搜到一个 issue：

[opencv/opencv_contrib#1661 Using Facemark API (Python), Version 4.0.0 - pre : bad alloc error](https://github.com/opencv/opencv_contrib/issues/1661)

里面主要说的是一个 C++ 函数的 BUG 导致导出 Python 接口时出现错误。Issue 的下面讲了很多，给人一种 BUG 已经修复的感觉。我去看了一下有 BUG 的那个文件，里面写了一句话：

```cpp
// FIX IT
```

也就是说，开发人员临时修了一下 BUG，但没有合并到 OpenCV 代码中。

**“官方 BUG 最为致命”**

此路不通，另寻他路。

> 2019-08-22 更新：此 BUG 已修复

## 0x02

我想到了以前装 RTTOV 时使用的 Manjaro Linux 系统，去仓库里搜了一下，有 OpenCV 软件包，而且这个软件包包含了扩展模块，可以拿来做开发环境。

那么问题来了，有些东西必须在 Windows 系统中使用，怎样兼顾呢？

方法有几种：

1. Windows + WSL
2. Windows + 虚拟机 + Manjaro
3. 其他方法

官方 WSL 不含 Manjaro 或者 Arch Linux 系统，想安装的话可以使用 [Arch Wiki](https://wiki.archlinux.org/) 推荐的 [ArchWSL](https://github.com/yuk7/ArchWSL) 项目，安装也很简单，跟着文档一步步来就行。

系统安装完毕后，开始安装软件包：

```sh
pacman -S opencv
```

此时可以使用 SSH 连接 WSL 进行开发了。

```sh
# 安装OpenSSH
pacman -S openssh
# 开机启动SSH
systemctl enable sshd.service
# 配置SSH可以使用用户名密码登录
vi /etc/ssh/sshd_config
# 将 PasswordAuthentication yes 前的 # 去掉
# 重启SSH服务
systemctl restart sshd.service
```

**「二号坑已就位」**

屏幕上出现一行字：`System has not been booted with systemd as init system (PID 1). Can't operate.`

搜了一下，在 GitHub 上找到一个 issue：

[Microsoft/WSL#1579 WSL does not support systemd / an init system, so you cannot use services. You have to run the commands yourself.](https://github.com/Microsoft/WSL/issues/1579)

**官方：我不支持，嘿嘿嘿**

从别的地方找到了启用 sshd 的方法，开启一个 terminal，使用 nohup 启用 sshd 服务在后台运行：

```sh
nohup /usr/bin/sshd -D >> ~/output.log 2>&1 &
```

使用 IDE 链接 WSL，配好编译环境，写好测试代码，一切很顺利的样子。

**「三号坑已就位」**

在我封装好摄像头类进行测试的时候，控制台里多了几行字，系统在问我：“摄像头是啥？”

WSL 貌似不能使用一些外设。

## 0x03

虚拟机总能用外设了吧。装个编译程序用的虚拟机，不需要分配太多的资源。安装过程很顺利，摄像头也能够使用。

**「四号坑已就位」**

把虚拟机放后台再开个 IDE，内存占用 90%多。此法可行，但条件不允许啊。

## 0x04

搜了一下使用 MinGW 编译的 OpenCV，GitHub 上有一个项目，[OpenCV-MinGW-Build](https://github.com/huihut/OpenCV-MinGW-Build)，但没有扩展模块。里面有编译方法，我参照它开始了我的编译之路。

参照教程使用 CMake 生成 Makefile，使用 mingw32-make.exe 进行编译

```sh
mingw32-make.exe -j8
```

启用 8 线程，看着那满载的 CPU，感觉这次稳了。

**「五号坑已就位」**

在编译到 `videoio` 模块时报错，原因是 MinGW 自带的头文件 aviriff.h 注释错误，文件第一行的多行注释少一个 `/` 符号，修正错误后继续编译，后面报了一些 Warning，没有出现 Error。

完成后参照[在 VSCode 中使用 OpenCV](https://stackoverflow.com/questions/51622111/opencv-c-mingw-vscode-fatal-error-to-compile/51801863#51801863)博客，编写好 Makefile 文档，进行测试。

**「六号坑已就位」**

能编译、能链接但不能运行。原因是缺少依赖库。

## 0x05

在博客[在 VSCode 中使用 OpenCV](https://stackoverflow.com/questions/51622111/opencv-c-mingw-vscode-fatal-error-to-compile/51801863#51801863)的底部有两条评论，提供了两种在 Windows 系统中安装使用 OpenCV 的方法：

1. 使用 [MSYS2](https://msys2.org/) 安装 OpenCV；
1. 使用 vcpkg (MS packager to install windows based open source projects)安装 OpenCV。

MSYS2 可以看做 Windows 下的 Arch Linux，与 WSL 不同，MSYS2 里面的包都是编译成 Windows 平台的 exe、dll 等文件，而 WSL 中的包是编译成 elf、so 等文件。

## 0x06 MSYS2 + OpenCV 环境配置

### Step 1 下载安装

到官网下载 MSYS2 安装包，安装完成后配置包镜像。并将目录

```txt
/path/to/MSYS2/mingw64/bin
```

添加到环境变量中。

### Step 2 安装相关的包

```sh
# 如果没有安装 toolchain，安装一下
pacman -S mingw-w64-x86_64-toolchain
# 安装 OpenCV
pacman -S mingw-w64-x86_64-opencv
```

### Step 3 配置 VSCode 开发环境

打开 VSCode 的设置文件，添加下列内容：

```txt
"C_Cpp.default.compilerPath": "/path/to/MSYS2/mingw64/bin/gcc.exe",
"C_Cpp.default.cppStandard": "c++11",
"C_Cpp.default.intelliSenseMode": "gcc-x64"
```

### Step 4 编写项目 Makefile 文件

```makefile
CC = g++

CFLAGS += -g -Wall -I/path/to/MSYS2/mingw64/include/opencv4

LDFLAGS += -L/path/to/MSYS2/mingw64/lib \
	-lopencv_aruco \
	-lopencv_bgsegm \
	-lopencv_calib3d \
	-lopencv_ccalib \
	-lopencv_core \
	-lopencv_datasets \
	-lopencv_dnn -lopencv_dnn_objdetect \
	-lopencv_dpm \
	-lopencv_face \
	-lopencv_features2d -lopencv_xfeatures2d \
	-lopencv_flann \
	-lopencv_fuzzy \
	-lopencv_gapi \
	-lopencv_hdf \
	-lopencv_hfs \
	-lopencv_highgui \
	-lopencv_img_hash \
	-lopencv_imgcodecs -lopencv_imgproc -lopencv_ximgproc \
	-lopencv_line_descriptor \
	-lopencv_ml \
	-lopencv_objdetect -lopencv_xobjdetect \
	-lopencv_optflow \
	-lopencv_ovis \
	-lopencv_phase_unwrapping \
	-lopencv_photo -lopencv_xphoto \
	-lopencv_plot \
	-lopencv_reg \
	-lopencv_rgbd \
	-lopencv_saliency \
	-lopencv_sfm \
	-lopencv_shape \
	-lopencv_stereo \
	-lopencv_stitching \
	-lopencv_structured_light \
	-lopencv_superres \
	-lopencv_surface_matching \
	-lopencv_text \
	-lopencv_tracking \
	-lopencv_video -lopencv_videoio -lopencv_videostab \
	-lopengl32 \
	-lglu32

TARGET = # target

OBJS += # obj files

all:$(TARGET)
$(TARGET):$(OBJS)
	$(CC) $(CFLAGS) $(OBJS) -o $(TARGET) $(LDFLAGS)
$(OBJS):%.o:%.cpp
	$(CC) $(CFLAGS) -c $< -o $@

.PHONY:clean
clean:
	rm -r $(OBJS) $(TARGET)
```

### Step 5 编译运行

```sh
mingw32-make.exe
```

至此，环境配置完毕。

## 经验总结

1. 看博客一定要看到最后
1. 不要形成惯性思维

## 致谢

[MSYS2](https://msys2.org/)

[ArchWSL](https://github.com/yuk7/ArchWSL)

[Arch WiKi](https://wiki.archlinux.org/)

[OpenCV-MinGW-Build](https://github.com/huihut/OpenCV-MinGW-Build)及其开发者[huihut](https://blog.huihut.com/)
