import React from "react";

const index = () => {
  return (
    <div id="main" className="header " style={{ fontFamily: "JetBrains Mono" }}>
      <nav className="bg-white fixed top-0 w-full flex justify-between items-center px-[30px]">
        {/* Left-side navigation links */}
        <ul className="flex gap-[20px] list-none text-[16px] p-0 m-[30px] ml-[60px] items-center">
          <li>
            <a href="/dashboard">
              <img src="images\dailyquest logo.png" className="h-7 w-7"></img>
            </a>
          </li>
          <li>
            <a href="#main" className="hover:underline">
              Home
            </a>
          </li>
          <li>
            <a href="#" className="hover:underline">
              Features
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
          <a href="">
            <button className="px-4 py-2 text-[16px] hover:underline">
              Sign In
            </button>
          </a>
          /
          <a href="/register">
            <button className="px-4 py-2 text-[16px] hover:underline">
              Register
            </button>
          </a>
        </div>
      </nav>

      <div className="container max-w-[1920px] h-screen m-0 p-0 ">
        <div className="flex flex-col justify-center gap-5 ">
          {/* Header text */}
          <div
            id="front"
            className="homeText w-fit mx-auto p-5 text-[80px] text-center mt-[300px]"
          >
            Welcome to{" "}
            <span className="font-bold text-[100px]">DailyQuest</span>.
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
        <div
          id="about"
          className="flex flex-col justify-center gap-5 items-center"
        >
          <div className="w-fit mx-auto p-5 text-[80px] text-center mt-[225px]">
            ABOUT
          </div>
          <div
            id="row"
            className="flex justify-between flex-wrap mt-8 ml-80 mr-80"
          >
            <div id="aboutCol1" className="max-w-[1200px] text-[18px] w-1/2">
              <span className="font-extrabold text-[24px]">
                Build habits. Stay consistent. Level up your life.
              </span>{" "}
              <br></br>
              <br></br>
              DailyQuest is your personal habit-tracking companion designed to
              help you stay accountable and build routines that stick. Whether
              you're aiming for healthier habits, increased productivity, or
              personal growth, DailyQuest transforms your daily goals into a
              journey of progress. <br></br>
              <br></br>
              With intuitive tracking, smart reminders, and a rewarding
              experience, DailyQuest turns habit-building into an
              adventure—where every small win gets you closer to long-term
              success. <br></br>
              <br></br>
              Start your quest today and make consistency your superpower!
            </div>
            <div
              id="aboutCol2"
              className="flex items-center justify-center w-1/2 mx-auto"
            >
              <img src="images\jogging.jpg" className="w-[500px]"></img>
            </div>
          </div>
        </div>
        {/* Contact Section */}
        <div
          id="contact"
          className="flex flex-col justify-center gap-5 items-center"
        >
          <div className="w-fit mx-auto p-5 text-[80px] text-center mt-[225px]">
            CONTACT US
          </div>
        </div>
        <div className="flex justify-center flex-wrap mt-8">
          <div className="w-1/2 text-center mb-40">
            <span className="text-[24px]">CONTACT DETAILS</span>
            <p className="mt-10">
              Phone: <br></br>
              123-456-7890 <br></br>
              <br></br>
              Email: <br></br>
              DailyQuest@gmail.com <br></br>
              <br></br>
              Location: <br></br>
              Toronto, ON<br></br>
              <br></br>
            </p>
          </div>
        </div>

        {/* Footer */}
        <footer className="bg-black">
          <div className="mx-auto w-full max-w-screen-xl p-4 md:py-8">
            <div className="sm:flex sm:items-center sm:justify-between">
              <a
                href=""
                className="flex items-center mb-4 sm:mb-0 space=x=3 rtl:space-x-reverse"
              >
                <span className="self-center text-2xl font-semibold whitespace-nowrap dark:text-white">
                  DailyQuest
                </span>
              </a>
              <ul className="flex flex-wrap items-center mb-6 text-sm font-medium text-white sm:mb-0">
                <li>
                  <a href="#" className="hover:underline me-4 md:me-6">
                    About
                  </a>
                </li>
                <li>
                  <a href="#" className="hover:underline me-4 md:me-6">
                    Privacy Policy
                  </a>
                </li>
                <li>
                  <a href="#" className="hover:underline me-4 md:me-6">
                    Licensing
                  </a>
                </li>
                <li>
                  <a href="#" className="hover:underline me-4 md:me-6">
                    Contact
                  </a>
                </li>
              </ul>
            </div>
            <hr className="my-6 border-gray-200 sm:mx-auto dark:border-gray-700 lg:my-8" />
            <span className="block text-sm text-white sm:text-center dark:text-gray-400">
              © 2025{" "}
              <a href="#" className="hover:underline">
                DailyQuest™
              </a>
              . All Rights Reserved.
            </span>
          </div>
        </footer>
      </div>
    </div>
  );
};

export default index;
