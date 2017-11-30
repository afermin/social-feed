# Social feed

Contents table
-----------------

- [Apk installable - link](https://drive.google.com/open?id=108X4lcgc0gESkb_mdBVYsOnUoyvidm3H)
- [Structure](#structure)
- [Version control](#version)
- [Libraries](#libraries)

Structure
---------------

- [RxMVP] (https://github.com/patrick-doyle/android-rxmvp)
- [Dagger 2] (https://github.com/codepath/android_guides/wiki/Dependency-Injection-with-Dagger-2)
- [RxJava2] (https://github.com/amitshekhariitbhu/RxJava2-Android-Samples)
- [RxAndroid] (https://github.com/ReactiveX/RxAndroid)
- [Kotlin] (https://kotlinlang.org/docs/reference)


Version
---------------

    min_sdk_version='17'
    target_sdk_version='27'
    compile_sdk_version=27
    kotlin_version='1.1.60'
        
    android_support_version="27.0.1"
    dagger_version="2.11"
    okhttp_version="3.6.0"
    twitter_sdk_version="3.1.1"
    retrofit_version="2.2.0"
    rxbinding_version="2.0.0"

Libraries
---------------

```bash
dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar'])

    //Kotlin
    implementation "org.jetbrains.kotlin:kotlin-stdlib-jre7:$kotlin_version"
    implementation "org.jetbrains.anko:anko-common:0.9"

    //Android support
    implementation "com.android.support:appcompat-v7:$android_support_version"
    implementation "com.android.support:design:$android_support_version"
    implementation "com.android.support:support-v4:$android_support_version"
    implementation 'com.android.support.constraint:constraint-layout:1.0.2'

    //Rx
    implementation 'io.reactivex.rxjava2:rxandroid:2.0.1'
    implementation "com.jakewharton.rxbinding2:rxbinding-kotlin:$rxbinding_version"
    implementation "com.jakewharton.rxbinding2:rxbinding-support-v4:$rxbinding_version"
    implementation "com.jakewharton.rxbinding2:rxbinding-appcompat-v7-kotlin:$rxbinding_version"
    implementation "com.jakewharton.rxbinding2:rxbinding-design-kotlin:$rxbinding_version"

    //Dagger 2
    implementation "com.google.dagger:dagger:$dagger_version"
    kapt 'com.google.dagger:dagger-compiler:2.11'

    //Twitter
    compile "com.twitter.sdk.android:twitter:$twitter_sdk_version"

    //OkHttp
    compile "com.squareup.okhttp3:logging-interceptor:$okhttp_version"

    //For Images
    compile "com.squareup.picasso:picasso:2.5.2"
    compile "com.jakewharton.picasso:picasso2-okhttp3-downloader:1.1.0"
    compile 'jp.wasabeef:picasso-transformations:2.1.2'

    //Retrofit
    compile "com.squareup.retrofit2:retrofit:$retrofit_version"
    compile "com.squareup.retrofit2:converter-moshi:$retrofit_version"
    compile "com.squareup.retrofit2:adapter-rxjava2:$retrofit_version"

    //Font library
    compile "uk.co.chrisjenx:calligraphy:2.2.0"

}