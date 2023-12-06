package dependencies
import core.Dependencies

internal val androidComposeDependencies = listOf(
    Dependencies.coreKtx,
    //Dependencies.composeMaterial,
    Dependencies.composeMaterial3,
    Dependencies.composeActivity,
    Dependencies.composeUi,
    Dependencies.composePreviewUi,
    Dependencies.composeNavigation,
    Dependencies.material
)

internal val androidxLifeCycleDependencies = listOf(
    Dependencies.viewModel,
    Dependencies.liveData,
    Dependencies.runtimeCompose,
    Dependencies.viewModelSaveState,
    Dependencies.lifecycleService,
)

internal val coroutinesAndroidDependencies = listOf(
    Dependencies.kotlinCoroutines,
)

internal val coilImageLoadingDependencies = listOf(
    Dependencies.coil,
)

internal val networkDependencies = listOf(
    Dependencies.retrofit,
    Dependencies.moshiConverter,
    Dependencies.okhHttp3,
    Dependencies.okhHttp3Interceptor
)



