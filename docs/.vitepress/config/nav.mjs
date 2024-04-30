/** @type { import('vitepress').DefaultTheme.Config['nav'] } */
const nav = [
   {
      text: '博客',
      link: '/blog/',
   },
   {
      text: '设计模式',
      link: '/design-pattern/',
   },
   {
      text: 'Kotlin',
      items: [
         { text: '基础语法', link: '/kotlin/ch01' },
         { text: '类', link: '/kotlin/ch02' },
         { text: '函数和 Lambda 表达式', link: '/kotlin/ch03' },
         { text: '集合和序列', link: '/kotlin/ch04' },
         { text: '协程', link: '/kotlin/ch05' },
      ],
   },
]

export default nav
