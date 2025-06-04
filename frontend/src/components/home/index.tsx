import React from "react";

const index = () => {
  return (
    <div className="header" style={{ fontFamily: "JetBrains Mono" }}>
      <nav className="sticky top-0 flex justify-between items-center px-[30px]">

          {/* Left-side navigation links */}
          <ul className="flex gap-[20px] list-none text-[16px] p-0 m-[30px] ml-[60px] items-center">
            <li>
              <a href="/" ><img src="images\dailyquest logo.png" className="h-7 w-7"></img></a>
            </li>
            <li>
              <a href="/" className="hover:underline">Home</a>
            </li>
            <li>
              <a href="/about" className="hover:underline">About</a>
            </li>
            <li>
              <a href="/contact" className="hover:underline">Contact</a>
            </li>
          </ul>

          {/* Right-side navigation links */}
          <div>
            <button className="px-4 py-2 text-[16px] hover:underline">Sign In</button>
          </div>
        </nav>

      <div className="container max-w-[1920px] h-screen m-0 p-0">
        <div className="flex flex-col justify-center gap-5">

          {/* Header text */}
          <div className="homeText w-fit mx-auto p-5 text-[80px] text-center mt-[225px]">
            Welcome to <span className="font-extrabold">DailyQuest</span>.
          </div>
        </div>

        <div className="flex flex-col justify-center gap-5 items-center">
          <a href="/register">
            <button className="bg-blue-500 hover:bg-blue-700 transition duration-300 text-white px-6 py-2 text-[16px] rounded-md font-bold cursor-pointer">
              Get Started
            </button>
          </a>
          
          {/* Dashboard image */}
          <section className="text-left max-w-[1200px] mx-auto p-5 border border-gray-300 rounded-lg mt-5">
            <img src='images\dailyquest.png'></img>
          </section>
        </div>
        <div className="w-fit mx-auto p-5 text-[80px] text-center mt-[225px]">
          ABOUT
        </div>
        <div className="w-fit mx-auto p-5 text-[80px] text-center mt-[225px]">
          CONTACT
        </div>
      </div>
    </div>
  );
};

export default index;
