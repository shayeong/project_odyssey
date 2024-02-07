import React, { useState } from "react";
import { Link } from "react-router-dom";
import Logo from "../res/logo.png";
const NavBar = () => {
  const [dropdwonVisible, setDropdwonVisible] = useState(false);

  const toggleDropDwon = () => {
    setDropdwonVisible(!dropdwonVisible);
  };
};

const Header = () => {
  return (
    <header>
      <nav className="navbar navbar-expand-lg navbar-light bg">
        <img src={Logo} width="110px" height="58px" alt="Logo" />
        <span className="logo-text">국내여행 플래너</span>
        <button
          className="navbar-toggler"
          type="button"
          data-toggle="collapse"
          data-target="#navbarNavDropdown"
          aria-controls="navbarNavDropdown"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse" id="navbarNavDropdown">
          <ul className="navbar-nav">
            <li className="nav-item active">
              여행리뷰 <span className="sr-only">(current)</span>
            </li>
            <li className="nav-item">
              <a className="nav-link" href="/howTo.pdf">
                이용방법
              </a>
            </li>
          </ul>
        </div>
      </nav>
    </header>
  );
};

export default Header;
