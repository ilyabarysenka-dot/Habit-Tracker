### Habit Tracker — Android Project

This repository contains an Android project created to explore modern Android development in depth.
The project focuses on architecture, modularization, and real-world features, rather than being a minimal demo.

The application is a habit tracker that demonstrates how to build a scalable Android app using:

Jetpack Compose
Multi-module architecture
Dependency Injection
Offline-first data handling
Modern navigation patterns

🎯 Project goals

Practice building a real application from scratch
Explore multi-module project structure
Learn how features interact through clean boundaries
Experiment with modern Android APIs and libraries
Serve as a reference project for future Android development

### 🧩 Modularization

[📄 Architecture PNG](docs/modulization.png)

## 🧱 Core modules
:core:common

This module contains shared, platform-independent utilities used throughout the project.
It acts as a foundation for the rest of the codebase and avoids any Android-specific APIs.

Typical content:

Result and error wrappers
Logging abstractions
String providers
Common exceptions
Coroutine helpers and utilities
Because this module is pure Kotlin, it can be reused across different layers without introducing Android dependencies.

## :core:ui
This module represents the design system of the application.
It centralizes all UI-related building blocks so that features remain visually consistent and easy to maintain.

Typical content:
Application theme
Color palettes and typography
Reusable Compose UI components
Common UI states and helpers
Feature modules consume this module to build screens without duplicating UI logic.

## :core:navigation
This module contains navigation infrastructure shared across the app.

It provides:

Navigation 3 setup
Type-safe route definitions
Navigation abstractions and helpers
Actual navigation destinations (screens) are implemented inside feature modules, while this module focuses on providing the tools needed to connect them.

## :core:network
This module encapsulates network-related infrastructure.

Typical content:

HTTP client setup (e.g. Retrofit / Ktor)
API service definitions
Network interceptors
Serialization configuration
Network error handling
By isolating networking concerns, the rest of the app remains independent of specific networking implementations.

## :core:database
This module contains local persistence infrastructure.

Typical content:
Room database setup
DAOs
Database entities
Migrations
This module exposes database access through clean APIs and does not depend on UI or feature modules.

## :core:notification
This module encapsulates notification-related logic.

Typical content:
Notification channel definitions
Notification builders
Scheduling helpers for reminders
Abstractions for local notifications
By isolating this logic, features can trigger notifications without dealing with low-level Android APIs.

📦 Data module
## :data
The data module is responsible for providing application data from various sources.

It contains:
Repository implementations
Integration with :core:network
Integration with :core:database
Data transfer objects (DTOs)
Mappers between network, database, and domain models
This module focuses on data access and persistence and does not contain UI or presentation logic.

## 🧩 Feature modules
:feature:*
Each feature module represents a vertical slice of functionality.

Typical content:
ViewModels
Compose screens
Feature-specific domain logic
Navigation entries related to the feature
Feature modules depend only on:
Core modules
Navigation module
Required abstractions from the data layer
By keeping features isolated, the project remains scalable and easier to reason about as new functionality is added.

📱 App module
:app
The app module is the entry point of the application.

It contains:
Application and activity setup
App-level navigation composition
Dependency injection setup
Startup and initialization logic
Most high-level configuration happens here, while actual functionality lives in core, data, and feature modules.