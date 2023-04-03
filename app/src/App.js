import React from 'react';
import './App.css';
import NavbarElements from './components/Navbar';
import { BrowserRouter as Router, Routes, Route}
    from 'react-router-dom';
// import Home from './pages';
import CreateCaloriesGoal from './pages/createCaloriesGoals/createCaloriesGoal';
import GetCaloriesBurned from './pages/getCaloriesBurned';
import DeleteCaloriesGoal from './pages/deleteCaloriesGoals/deleteCaloriesGoal';
  
function App() {
return (
    <Router>
    <NavbarElements />
    <Routes>
        {/* <Route exact path='/' element={<Home />} /> */}
        <Route path='/CreateCaloriesGoal' element={<CreateCaloriesGoal/>} />
        <Route path='/GetCaloriesBurned' element={<GetCaloriesBurned/>} />
        <Route path='/DeleteCaloriesGoal' element={<DeleteCaloriesGoal/>} />
    </Routes>
    </Router>
);
}
  
export default App;