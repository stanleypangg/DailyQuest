import React from "react";
import "./index.css";

const Dashboard = () => {
  return (
    <div className="m-0 p-0 font-['JetBrains_Mono']">
      <div
        id="grid-container"
        className="grid grid-cols-[260px_1fr_1fr_1fr] grid-rows-[70px_1fr] h-screen"
      >
        {/* Header */}
        <header
          id="header"
          className="bg-white flex items-center justify-between px-8 shadow-[0_6px_7px_-3px_rgba(0,0,0,0.35)]"
        >
          <h1 className="text-xl font-bold">DailyQuest Dashboard</h1>
          <div className="flex items-center gap-4 shadow-md">
            <button className="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600 transition">
              Log Out
            </button>
          </div>
        </header>

        {/* Sidebar */}
        <aside
          id="sidebar"
          className="bg-white overflow-y-auto transition-all duration-500 p-6 shadow-md"
        >
          <nav className="flex flex-col gap-4">
            <a href="#" className="text-lg hover:text-blue-600 transition">
              📊 Overview
            </a>
            <a href="#" className="text-lg hover:text-blue-600 transition">
              ✅ Habits
            </a>
            <a href="#" className="text-lg hover:text-blue-600 transition">
              📈 Progress
            </a>
            <a href="#" className="text-lg hover:text-blue-600 transition">
              ⚙️ Settings
            </a>
          </nav>
        </aside>

        {/* Main Content */}
        <main
          id="main-container"
          className="bg-white overflow-y-auto p-6 shadow-md"
        >
          <section className="mb-6">
            <h2 className="text-2xl font-semibold mb-2">Welcome back!</h2>
            <p className="text-gray-700">
              Here's your habit progress for today.
            </p>
          </section>

          <section className="grid grid-cols-3 gap-6">
            <div className="bg-white p-4 rounded shadow-md">
              <h3 className="text-lg font-bold mb-2">🧘 Meditation</h3>
              <p>Completed 3 of 7 days</p>
            </div>
            <div className="bg-white p-4 rounded shadow-md">
              <h3 className="text-lg font-bold mb-2">🏃 Exercise</h3>
              <p>Completed 5 of 7 days</p>
            </div>
            <div className="bg-white p-4 rounded shadow-md">
              <h3 className="text-lg font-bold mb-2">📚 Reading</h3>
              <p>Completed 6 of 7 days</p>
            </div>
          </section>
        </main>
      </div>
    </div>
  );
};

export default Dashboard;
