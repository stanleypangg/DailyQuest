import React from "react";

const index = () => {
  return (
    <div className="header" style={{ fontFamily: "JetBrains Mono" }}>
      <div className="container max-w-[1920px] h-screen m-0 p-0">
        <nav className="flex justify-between items-center px-[30px]">
          {/* Left-side navigation links */}
          <ul className="flex gap-[20px] list-none text-[16px] p-0 m-[30px] ml-[60px]">
            <li>
              <a href="/">Home</a>
            </li>
            <li>
              <a href="/about">About</a>
            </li>
            <li>
              <a href="/contact">Contact</a>
            </li>
          </ul>

          {/* Right-side navigation links */}
          <div>
            <button className="px-4 py-2 text-[16px]">Sign In</button>
            <a href="/register">
              <button className="bg-blue-500 hover:bg-blue-700 transition duration-300 text-white px-6 py-3 text-[16px] rounded-md font-bold cursor-pointer">
                Get Started
              </button>
            </a>
          </div>
        </nav>

        <div className="flex flex-col justify-center gap-5">
          {/* Header text */}
          <div className="homeText w-fit mx-auto p-5 text-[70px] text-center mt-[225px]">
            Welcome to <b>Daily Quest.</b>
          </div>
        </div>

        <div className="flex flex-col justify-center gap-5 items-center">
          <a href="/register">
            <button className="bg-blue-500 hover:bg-blue-700 transition duration-300 text-white px-6 py-3 text-[22px] rounded-md font-bold cursor-pointer">
              Get Started
            </button>
          </a>

          <section className="text-left max-w-[1100px] mx-auto p-5 border border-gray-300 rounded-lg mt-5">
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam
            feugiat tortor lectus, et laoreet lacus pharetra sit amet. Nam ut
            elementum erat, accumsan laoreet massa. Suspendisse ac posuere odio,
            eget porttitor leo. Etiam consequat, ex at posuere mattis, leo nisi
            convallis erat, quis luctus nulla augue at diam. Aenean finibus nunc
            non volutpat elementum. Integer posuere nisi eget finibus volutpat.
            Suspendisse ut semper ipsum. Pellentesque iaculis felis id mauris
            placerat blandit. Pellentesque pretium mollis pretium. Vivamus
            tincidunt at metus a ultricies. Aenean pulvinar risus orci, eget
            fermentum metus fringilla vel. Quisque tempor orci a metus faucibus
            egestas. Maecenas dignissim molestie nulla, at pulvinar eros
            molestie non. Nullam vitae quam turpis. Fusce sodales eros in
            condimentum convallis. Morbi non nibh pulvinar lectus laoreet
            varius. Ut rhoncus, diam non rutrum ultricies, neque lectus viverra
            erat, non rhoncus nisl diam non quam. Nulla ultricies sit amet eros
            vel rutrum. Pellentesque placerat velit sed vulputate tincidunt. Ut
            hendrerit aliquet dui at iaculis. Fusce congue, nulla sed sodales
            vulputate, justo purus tincidunt libero, sit amet convallis odio
            mauris sed turpis. Sed orci orci, mattis tincidunt dignissim id,
            pulvinar in enim. Curabitur suscipit turpis quam, quis ultricies
            diam consequat ac. Ut congue sapien sed fringilla vestibulum. Morbi
            ac faucibus turpis, a vehicula dolor. Nam sed eros a ipsum maximus
            imperdiet. Fusce at velit ac nibh mattis semper id sed urna. Mauris
            vehicula est pellentesque ipsum tempor dapibus. Quisque ullamcorper
            tristique mauris, ac fermentum eros molestie id. Nullam quis leo
            nisl. Donec sapien magna, interdum sed scelerisque ac, imperdiet ac
            lacus. Ut placerat dapibus odio. Duis id libero non dui porta
            pellentesque ut ac lectus. Ut mollis justo odio, at eleifend orci
            volutpat vitae. Etiam urna dui, rhoncus sed tristique nec, finibus
            vitae justo. Phasellus non arcu eu tortor iaculis malesuada. Nunc a
            velit sit amet mi egestas vestibulum. Suspendisse viverra in sem sit
            amet condimentum. Nam vel feugiat risus. Integer rutrum pharetra
            massa, vitae lobortis tellus interdum ut. Aliquam erat volutpat. Sed
            arcu quam, pulvinar quis hendrerit eget, placerat eu nibh. Nunc at
            venenatis ligula. Curabitur sit amet congue nisl, sed bibendum ex.
            Pellentesque habitant morbi tristique senectus et netus et malesuada
            fames ac turpis egestas. Nunc finibus felis eu ullamcorper laoreet.
            Curabitur fermentum ipsum sit amet nisl convallis pellentesque.
            Quisque ac consectetur tortor, nec ultrices justo. Etiam risus enim,
            commodo venenatis ultrices nec, laoreet sit amet lorem. Nullam
            ultrices sapien turpis, vitae maximus quam varius sit amet. Morbi
            sed nisl rhoncus, pulvinar quam nec, pretium elit. Sed ut tempus
            ante. Curabitur eget lectus fringilla, sollicitudin diam pharetra,
            ultrices purus. Suspendisse porta sapien placerat, pulvinar ante eu,
            lobortis libero.
          </section>
        </div>
      </div>
    </div>
  );
};

export default index;
