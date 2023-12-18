# 使用 GitHub Actions 自动编译并推送至 Pages 仓库

本项目使用 VitePress 搭建，在推送源代码至 GitHub 仓库时，通过 GitHub Actions 自动编译并将编译产物推送至 GitHub Pages

## Actions 工作流分段解析

### 触发方式

```yml
name: deploy site to github pages

on:
   push:
      branches: master
```

### 任务名称、运行环境

```yml
jobs:
   build:
      runs-on: ubuntu-latest
```

### 环境变量

> VitePress 生成目录、Pages 仓库路径、Pages 仓库分支

```yml
jobs:
   build:
      # ...
      env:
         PAGES_PATH: docs/.vitepress/dist
         REPO: https://github.com/SunYufei/sunyufei.github.io.git
         BRANCH: master
```

### 步骤 1：克隆本仓库

```yml
jobs:
   build:
      # ...
      steps:
         - uses: actions/checkout@v4
           with:
              fetch-depth: 0 # git clone --depth=0
```

### 步骤 2：克隆 Pages 仓库

> 使用 GitHub Personal Access Token 进行克隆

```yml
jobs:
   build:
      # ...
      steps:
         # ...
         - name: Clone pages repo
           run: |
              git config --global url."https://x-access-token:${{ secrets.ACTIONS_TOKEN }}@github.com".insteadOf "https://github.com"
              mkdir -p $PAGES_PATH
              git clone $REPO $PAGES_PATH -b $BRANCH
              ls $PAGES_PATH
```

### 步骤 3：安装 Node.js 环境

```yml
jobs:
   build:
      # ...
      steps:
         # ...
         - uses: actions/setup-node@v4
           with:
              node-version: 18
```

### 步骤 4：安装项目依赖

```yml
jobs:
   build:
      # ...
      steps:
         # ...
         - name: Install dependencies
           run: yarn install
```

### 步骤 5：构建项目

```yml
jobs:
   build:
      # ...
      steps:
         # ...
         - name: Build with VitePress
           run: yarn build
```

### 步骤 6：将构建产物推送至 Pages 仓库

> 推送说明为本仓库最近一次推送信息

```yml
jobs:
   build:
      # ...
      steps:
         # ...
         - name: Push to pages repo
           run: |
              LAST_COMMIT=$(git rev-parse --short HEAD)
              AUTHOR=$(git show --no-patch --format='%an' $LAST_COMMIT)
              EMAIL=$(git show --no-patch --format='%ae' $LAST_COMMIT)
              MESSAGE=$(git show --no-patch --format='%s' $LAST_COMMIT)
              #
              cd $PAGES_PATH
              git config --global user.name $AUTHOR
              git config --global user.email $EMAIL
              git status
              git add .
              git commit -m "$MESSAGE"
              git push -f origin $BRANCH
```
