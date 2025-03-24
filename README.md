# 🛍️ ProductSearchApp

Una aplicación Android desarrollada en **Kotlin + Jetpack Compose** con arquitectura **Clean Architecture**, principios **SOLID**, e inyección de dependencias usando **Hilt**.

Permite buscar productos desde una API REST, mostrar los resultados con título, precio e imagen,también guarda el historial de búsquedas usando DataStore.

---

## ✅ Requisitos

- Android Studio Giraffe o superior
- Android SDK 31 o superior (Android 12+)
- Conexión a Internet
- API Key válida para realizar las búsquedas

---

## 🔐 Configuración de la API Key

1. Abre el archivo `local.properties` en el proyecto raíz.
2. Agrega la siguiente línea:

```
API_KEY="TU_API_KEY_AQUI"
BASE_URL="TU_BASE_URL_AQUI"
```

3. Asegúrate de que en tu `build.gradle` (nivel app) exista esta línea:

```kotlin
buildConfigField "String", "API_KEY", "\"${apiKey}\""
buildConfigField "String", "BASE_URL", "\"${baseUrl}\""
```

---

## 📦 Dependencias requeridas

Agrega lo siguiente en tu `build.gradle (Module)`:

```kotlin
// Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.androidx.runtime.livedata)
    implementation(libs.logging.interceptor)

    //gson
    implementation(libs.gson)

    //navigation
    implementation(libs.navigation)

    // hilt
    implementation(libs.hilt.android)
    implementation(libs.hilt.compose)
    kapt(libs.hilt.android.compiler)

    // serialization
    implementation(libs.serialization)

    // coil
    implementation(libs.coil.compose)

    // paging
    implementation(libs.androidx.paging.runtime)
    implementation(libs.androidx.paging.compose)

    // datastore
    implementation(libs.androidx.datastore.preferences)

    // coroutine
    implementation(libs.kotlinx.coroutines.android)
```

---

## 🛠️ Estructura del Proyecto

```
app/
├── data/            # DTOs, Retrofit, repositorio impl.
├── domain/          # Modelos, casos de uso
├── view/            # UI con Jetpack Compose + Navegación
├── di/              # Módulos de Hilt
```
