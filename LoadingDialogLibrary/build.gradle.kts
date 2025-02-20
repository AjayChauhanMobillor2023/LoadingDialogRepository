plugins {
        id("com.android.library")
        id("org.jetbrains.kotlin.android")
        id ("maven-publish")
}

group = "com.github.AjayChauhanMobillor2023"  // Use your GitHub username
version = "1.0.3"

android {
        namespace = "com.example.loadingdialoglibrary"
        compileSdk = 34

        defaultConfig {
                minSdk = 24

                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                consumerProguardFiles("consumer-rules.pro")
        }

        buildTypes {
                release {
                        isMinifyEnabled = false
                        proguardFiles(
                                getDefaultProguardFile("proguard-android-optimize.txt"),
                                "proguard-rules.pro"
                        )
                }
        }
        compileOptions {
                sourceCompatibility = JavaVersion.VERSION_1_8
                targetCompatibility = JavaVersion.VERSION_1_8
        }
        kotlinOptions {
                jvmTarget = "1.8"
        }
}

dependencies {

        implementation("androidx.core:core-ktx:1.13.1")
        implementation("androidx.appcompat:appcompat:1.7.0")
        implementation("com.google.android.material:material:1.12.0")
        implementation("androidx.constraintlayout:constraintlayout:2.2.0")
        testImplementation("junit:junit:4.13.2")
        androidTestImplementation("androidx.test.ext:junit:1.2.1")
        androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
}


publishing{
        publications{
                register<MavenPublication>("release"){
                        afterEvaluate{
                                from (components["release"])
                                groupId ="com.github.AjayChauhanMobillor2023" // GitHub username
                                artifactId = "LoadingDialogLibrary"      // GitHub repository name
//                                version = "1.0.0"
                        }
                }
        }
}