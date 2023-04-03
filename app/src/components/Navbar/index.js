
import React from "react";
import { Nav, NavLink, NavMenu } 
    from "./NavbarElements";
  
const Navbar = () => {
  return (
    <>
      <Nav>
        <NavMenu>
          <NavLink to="/getCaloriesBurned" activeStyle>
            Daily Calories Burned
          </NavLink>
          <NavLink to="/createCaloriesGoal" activeStyle>
            Create Calories Goal
          </NavLink>
          <NavLink to="/deleteCaloriesGoal" activeStyle>
            Delete Calories Goal
          </NavLink>
        </NavMenu>
      </Nav>
    </>
  );
};
  
export default Navbar;