package core

internal object Dependencies {
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtxVersion}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.materialVersion}"
    const val composeMaterial3 ="androidx.compose.material3:material3:1.0.0-beta03"
    const val material ="com.google.android.material:material:1.8.0-alpha01"
    const val composeActivity = "androidx.activity:activity-compose:${Versions.activityComposeVersion}"
    const val composeUi = "androidx.compose.ui:ui:${Versions.composeVersion}"
    const val composeNavigation = "androidx.navigation:navigation-compose:${Versions.composeNavigationVersion}"
    const val composePreviewUi = "androidx.compose.ui:ui-tooling-preview:${Versions.composeVersion}"

    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycleVersion}"
    const val viewModelSaveState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.lifecycleVersion}"
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleVersion}"
    const val runtimeCompose = "androidx.lifecycle:lifecycle-runtime-compose:${Versions.runtimeComposeVersion}"
    const val lifecycleService = "androidx.lifecycle:lifecycle-service:${Versions.lifecycleVersion}"

    val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hiltVersion}"
    const val hiltNavCompose = "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigationComposeVersion}"
    val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hiltVersion}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    //const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"
    const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.moshiConverter}"
    const val okhHttp3 = "com.squareup.okhttp3:okhttp:${Versions.okhttp3Version}"
    const val okhHttp3Interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp3Version}"
    //const val gson = "com.google.code.gson:gson:${Versions.gsonVersion}"

    const val moshi = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
    const val moshiCodegen = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"

    const val kotlinCoroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesVersion}"
    const val leakcanary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakcanaryVersion}"
    const val timber = "com.jakewharton.timber:timber:${Versions.timberVersion}"
    const val coil = "io.coil-kt:coil-compose:${Versions.coilVersion}"

    const val room = "androidx.room:room-runtime:2.5.1"
    const val roomCompiler = "androidx.room:room-compiler:2.5.1"
    const val roomKtx = "androidx.room:room-ktx:2.5.1"
    const val roomPaging = "androidx.room:room-paging:2.5.1"

    const val jUnit = "androidx.compose.ui:ui-test-junit4:${Versions.composeVersion}"
    const val jUnitExt = "androidx.test.ext:junit:${Versions.jUnitExtVersion}"
    const val jUnitTestUi = "androidx.compose.ui:ui-test-junit4:${Versions.composeVersion}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espressoCoreVersion}"
    const val composeTooling = "androidx.compose.ui:ui-tooling:${Versions.composeVersion}"
    const val composeTestManifest = "androidx.compose.ui:ui-test-manifest:${Versions.composeVersion}"

}