# bsdiff-android

### 增量更新验证demo

操作验证步骤 以（/Users/zx/Desktop/apk_test/bsdiff）目录为例：
1. 生成bs_old.apk
2. 改动后生成bs_new.apk
3. 执行bsdiff bs_old.apk bs_new.apk bs_patch 生成bs_patch
4. 执行 adb push /Users/zx/Desktop/apk_test/bsdiff/bs_patch /sdcard/bs_patch
5. 安装bs_old.apk  点击更新  在/storage/emulated/0/目录下会生成composed_apk.apk
6. 安装composed_apk 检查更新内容是否与bs_new.apk一致
