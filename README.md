# 📲 Android Portfolio App (Sayjan J. Singh)

A multi-screen Android portfolio app built with Kotlin and Firebase that showcases certifications, achievements, education, and projects — dynamically pulled from Firestore. Includes a feedback form that submits real-time user responses to Firebase, and demonstrates solid Android fundamentals with MVVM architecture.

---

## 🚀 Features

🔹 Clean, interactive UI using native Android components (no external UI libraries)
🔹 Multi-screen navigation with intent-based data passing
🔹 **Certifications** and **Projects** loaded dynamically from Firestore
🔹 Feedback form with validation and real-time database storage
🔹 ViewBinding throughout the app for type-safe view access
🔹 Image loading via Glide
🔹 MVVM architecture for separation of concerns
🔹 Designed with performance, readability, and scalability in mind

---

## 🔧 Tech Stack

| Layer | Tools |
|-------|-------|
| Language | Kotlin |
| UI | Android XML, ViewBinding |
| Backend | Firebase Firestore |
| Image Loading | Glide |
| Architecture | MVVM |
| IDE | Android Studio |
| Version Control | Git + GitHub |

---

## 🛠 Setup Instructions

1. Clone this repo
2. Add your own `google-services.json` to the `/app` directory
3. Create Firestore collections:
   - `certifications` with fields: `title`, `platform`, `image`, `url`
   - `projects` with fields: `title`, `image`, `url`
   - (Optional) `feedback` with fields: `name`, `email`, `message`
4. Run the project via Android Studio

---

## 📄 License

This project is open-source and built for learning and demonstration purposes.

---

## 👨‍💻 Author

**Sayjan J. Singh**  
📧 sayjan7777@gmail.com  
🔗 [LinkedIn](https://www.linkedin.com/in/sayjan-j-singh/)  
🐙 [GitHub](https://github.com/Sia714)

---

