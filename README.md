# Tenant Management System

An Android Studio project for the Tenant Management practicals. It uses Kotlin, XML layouts, Activities, Intents, Fragments, a Navigation Graph, Safe Args, and a navigation drawer.

## Open in Android Studio

Open Android Studio, choose **Open**, and select this project folder. Allow Gradle sync to finish, select an emulator, and press **Run**.

The project uses Android Gradle Plugin 8.11.1, Gradle 8.13, Kotlin 2.2.20, and Java 17. Android Studio may download Gradle and Android dependencies during sync.

## App flow

- Login opens the Dashboard and passes the email to the navigation drawer.
- The Dashboard shows the tenant count and total rent, and opens Add Tenant or View Tenants.
- Add Tenant checks the fields, saves a tenant to the in-memory list, and passes it to View Tenants with Safe Args.
- View Tenants shows the new tenant, lists saved tenants, and opens the dialer with the tenant's number.
- The App Bar has a View Tenants and Logout menu. The navigation drawer links to the three main screens.
- Navigation animations, back-stack behavior, and Activity and Dashboard Fragment lifecycle logs are included.

Login and registration are demonstration screens; account details are not stored or checked against an account database. Tenant data stays in memory while the app is running.
