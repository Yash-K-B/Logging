[![](https://jitpack.io/v/yash-k-b/logging.svg)](https://jitpack.io/#yash-k-b/logging)
[![Generic badge](https://img.shields.io/badge/Build-passing-<COLOR>.svg)]()

# Logging
  Logging library for android.
  
  
# Add To Your Project
```gradle
  allprojects {
      repositories {
        ...
        maven { url 'https://jitpack.io' }
      }
    }
    
  dependencies {
	        implementation 'com.github.yash-k-b:logging:Tag'
	}

```

# How to use
> Add to your Application class
```java
  LogHelper.deploy(this, TAG);
```

# Available methods
```java
1. LogHelper.d(TAG,message);
2. LogHelper.e(TAG,message);
3. LogHelper.i(TAG,message);
4. LogHelper.v(TAG,message);
5. LogHelper.w(TAG,message);
```

# Setting
```java
 1. LogHelper.getLogHelperSettings().setConsoleLogging(true/false) - display/hide logs in console
 2. LogHelper.getLogHelperSettings().setFileLogging(true/false) - display/hide logs inside the app
 
```
  
  
  
# License
```
MIT License

Copyright (c) 2021 Yashobanta Kumar Behera

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

```
