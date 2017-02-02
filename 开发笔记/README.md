# 开发笔记

# 封装工具类
* log 
* sharedPreferences
* typeface
* 提示参数: command + P

# 欢迎页逻辑
## 全屏 
* 自定义style
```java
<item name="android:windowNoTitle">true</item>
<item name="android:windowFullscreen">true</item>
<item name="android:windowActionBar">false</item>
<item name="android:windowContentOverlay">@null</item>
```
* menifest中设定style

## 利用sharedPreference判断应用是否第一次使用
* sharedPreferences中存取一个boolean值


## hanldler实现延时
* 调用sendEmptyMessageDelayed

## 自定义字体
* 自定义字体，typeface加载assets中的ttf文件

```java
Typeface typeface = Typeface.createFromAsset(context.getAssets(), path);
textView.setTypeface(typeface);
```




# 引导页逻辑

## viewpager实现多页面
### view容器
* viewpager要配合List<View>容器使用
* 通过View.inflate()将layout加载成view
### adapter
* 与主页的fragment的Adapter不一样
* viewpager的Adapter是继承PagerAdapter
* 重载PagerAdapter中的方法
```java
1. getCount(): list.size()
2. isViewFromObject: view == object
3. instantiateItem： addView(list.get(position)) 
4. destroyItem: removeView(list.get(position))
```
* 技术细节: 重载方法时将container转成ViewPager类型可以直接操作

## 每个页面的跳过按钮
* 自定义shape背景 ： solid －> color ／ coners ——> radius: 圆角半径

## 最后页面的进入按钮
* 初始化非本activity的布局控件时，应先inflate别的view，再从view实例中find view；

