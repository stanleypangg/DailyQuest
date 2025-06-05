import React from "react";

const index = () => {
  return (
    <div className="header" style={{ fontFamily: "JetBrains Mono" }}>
      <nav className="bg-white fixed top-0 w-full flex justify-between items-center px-[30px]">
        {/* Left-side navigation links */}
        <ul className="flex gap-[20px] list-none text-[16px] p-0 m-[30px] ml-[60px] items-center">
          <li>
            <a href="/">
              <img src="images\dailyquest logo.png" className="h-7 w-7"></img>
            </a>
          </li>
          <li>
            <a href="#front" className="hover:underline">
              Home
            </a>
          </li>
          <li>
            <a href="#about" className="hover:underline">
              About
            </a>
          </li>
          <li>
            <a href="#contact" className="hover:underline">
              Contact
            </a>
          </li>
        </ul>

        {/* Right-side navigation links */}
        <div>
          <button className="px-4 py-2 text-[16px] hover:underline">
            Sign In
          </button>
        </div>
      </nav>

      <div className="container max-w-[1920px] h-screen m-0 p-0">
        <div className="flex flex-col justify-center gap-5">
          {/* Header text */}
          <div
            id="front"
            className="homeText w-fit mx-auto p-5 text-[80px] text-center mt-[300px]"
          >
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
            <img src="images\dailyquest.png"></img>
          </section>
        </div>
        {/* About Section */}
        <div id="about" className="flex flex-col justify-center gap-5 items-center">
          <div className="bg-black text-white w-full mx-auto p-5 text-[80px] text-center mt-[225px]">
            ABOUT
          </div>
          <div id='row' className="flex justify-between flex-wrap mt-8">
            <div id='aboutCol1' className="max-w-[1200px] text-[20px] w-1/2">
              <span className="font-extrabold text-[24px]">Build habits. Stay consistent. Level up your life.</span> <br></br>
              <br></br>
              DailyQuest is your personal habit-tracking companion designed to help you stay
              accountable and build routines that stick. Whether you're aiming for
              healthier habits, increased productivity, or personal growth,
              DailyQuest transforms your daily goals into a journey of progress. <br></br>
              <br></br>
              With intuitive tracking, smart reminders, and a rewarding
              experience, DailyQuest turns habit-building into an adventure—where
              every small win gets you closer to long-term success.  <br></br>
              <br></br>
              Start your quest today and make consistency your superpower!
            </div>
            <div id='aboutCol2' className="w-1/2">
              
            </div>
          </div>
        </div>
        {/* Contact Section */}
        <div id="contact" className="flex flex-col justify-center gap-5 items-center">
          <div className=" bg-black text-white w-full mx-auto p-5 text-[80px] text-center mt-[225px]">
            CONTACT
          </div>
        </div>
        <div id='row' className="flex justify-between flex-wrap mt-8">
          <div id="contactCol1" className="w-1/2 text-center">
            div 1
          </div>
          <div id="contactCol2" className="w-1/2 text-center">
            div 2
          </div>
        </div>
      </div>
    </div>
  );
};

export default index;
