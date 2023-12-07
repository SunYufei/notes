import { defineConfig } from 'vitepress'

export default defineConfig({
   lang: 'zh-CN',
   title: 'Notes',
   lastUpdated: true,
   rewrites: {
      ':path/README.md': ':path/index.md',
   },
   themeConfig: {
      nav: [
         {
            text: '博客',
            link: '/blog/',
         },
         {
            text: '设计模式',
            link: '/design-pattern/',
         },
      ],
      sidebar: {},
      socialLinks: [
         {
            icon: 'github',
            link: 'https://github.com/SunYufei',
         },
      ],
      outline: {
         label: '目录',
         level: 'deep',
      },
      lastUpdated: {
         text: '最近更新',
      },
      search: {
         provider: 'local',
      },
      footer: {
         message: 'All articles are under CC BY 4.0 license',
         copyright: 'Copyright (c) 2016-2023 SunYufei',
      },
   },
})
