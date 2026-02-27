# 社区前端应用

基于Android原生开发的社区应用，采用Java和Kotlin混合开发。

## 功能模块

- 用户认证系统（登录/注册/资料管理）
- 帖子发布/浏览/搜索系统
- 评论/回复/点赞功能
- 消息通知系统

## 技术栈

- Java
- Kotlin
- Android SDK
- Room Database
- Retrofit
- Glide

## 项目结构

```
app/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/community/
│   │   │   │   ├── auth/           # 用户认证模块
│   │   │   │   ├── post/           # 帖子管理模块
│   │   │   │   ├── comment/        # 评论管理模块
│   │   │   │   ├── notification/   # 消息通知模块
│   │   │   │   └── ui/            # 界面组件
│   │   │   └── ...
│   │   └── kotlin/
│   │       └── com/community/
│   │           ├── extensions/     # Kotlin扩展函数
│   │           └── utils/          # 工具类
│   └── ...
└── ...
```