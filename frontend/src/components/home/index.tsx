import React from "react";

const index = () => {
  return (
    <div className="header" style={{ fontFamily: "JetBrains Mono" }}>
      <div
        className="container"
        style={{ maxWidth: "1920px", height: "100vh", margin: 0, padding: 0 }}
      >
        <nav
          style={{
            display: "flex",
            justifyContent: "space-between",
            alignItems: "center",
            padding: "0 30px",
          }}
        >
          {/* Left-side navigation links */}
          <ul
            style={{
              display: "flex",
              gap: "20px",
              listStyle: "none",
              fontSize: "16px",
              padding: 0,
              margin: 30,
              marginLeft: 60,
            }}
          >
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
            <button style={{ padding: "8px 16px", fontSize: "16px" }}>
              Sign In
            </button>
            <button
              style={{
                backgroundColor: "#007bff",
                color: "#fff",
                padding: "12px 24px",
                fontSize: "16px",
                border: "none",
                borderRadius: "6px",
                cursor: "pointer",
                fontWeight: "bold",
              }}
            >
              Get Started
            </button>
          </div>
        </nav>

        <div
          style={{
            display: "flex",
            flexDirection: "column",
            justifyContent: "center",
            gap: "20px",
          }}
        >
          {/* Header text */}
          <div
            className="homeText"
            style={{
              width: "fit-content",
              margin: "0 auto",
              padding: "20px",
              fontSize: "70px",
              textAlign: "center",
              marginTop: "150px",
            }}
          >
            Welcome to <b>Daily Quest.</b>
          </div>
        </div>

        <div
          style={{
            display: "flex",
            flexDirection: "column",
            justifyContent: "center",
            alignItems: "center",
            gap: "20px",
          }}
        >
          <button
            style={{
              backgroundColor: "#007bff",
              color: "#fff",
              padding: "12px 24px",
              fontSize: "24px",
              border: "none",
              borderRadius: "6px",
              cursor: "pointer",
              fontWeight: "bold",
            }}
          >
            Get Started
          </button>

          <section
            style={{
              textAlign: "left",
              maxWidth: "1100px",
              margin: "auto",
              padding: "20px",
              border: "1px solid #ddd",
              borderRadius: "10px",
              marginTop: "20px",
            }}
          >
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
