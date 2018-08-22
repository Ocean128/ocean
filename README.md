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

网站：
[http://www.jcodecraeer.com/a/anzhuokaifa/Android_Studio/2015/0227/2502.html](http://www.jcodecraeer.com/a/anzhuokaifa/Android_Studio/2015/0227/2502.html)
[创建安卓库](https://developer.android.google.cn/studio/projects/android-library.html)
[创建Maven](http://blog.csdn.net/jinyp/article/details/55095310)