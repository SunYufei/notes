---
lastUpdated: 2020-02-12
---

# 通过 scp 在 Linux 之间互传文件

## scp 简介

传文件

```sh
scp file.ext user@ip:/path/
```

传目录

```sh
scp -r path user@ip:/path/
```

## 免密传输

如果没有配置好 SSH Key，上面的两个操作回要求输入密码。配置免密传输很简单，先将公钥文件传到目标服务器中

```sh
scp ~/.ssh/id_rsa.pub user@ip:/home/user
```

然后在目标服务器上将公钥添加到 `authorized_keys` 文件中

```sh
cat id_rsa.pub >> ~/.ssh/authorized_keys
```

此时传输文件不需要输密码了

## 后台传输

文件量巨大，前台传输的话当 ssh 断开传输就停止了

若已配置好 ssh 免密登录，可以使用 `nohup` 命令将其放到后台运行，关闭终端后文件传输不会中断

```sh
nohup scp -r /home/user user@ip:/home/user &
```

若不能配置 ssh 免密登录，需要使用密码方式传输，可以采用如下方式后台运行

1. 正常执行 scp 命令

   ```sh
   scp -r path user@ip:/path/
   ```

1. 按下 `ctrl + z` 暂停任务
1. 输入 `bg` 命令将任务放入后台
1. 输入 `disown -h` 命令将这个作业忽略 HUP 信号
