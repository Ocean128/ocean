# ocean
在工程的build.gradle添加如下代码：

```
allprojects {
    repositories {
        google()
        jcenter()
        maven { url 'https://jitpack.io' }
    }
}
```

在项目的build.gradle添加依赖：

```
compile 'com.github.Ocean128:ocean:V0.0.1'
```

