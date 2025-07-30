import React from "react";
import { BrowserRouter as Router, Routes, Route, Navigate } from "react-router-dom";
import NavBar from "./Components/NavBar";
import Dcards from "./Components/Dcards";
import BookingForm from "./Components/BookingForm";
import "./App.css";

const App = () => {
  return (
    <Router>
      <div className="App">
        <NavBar />
        <Routes>
          {/* Redirect from "/" to "/locations" */}
          <Route path="/" element={<Navigate to="/locations" />} />
          <Route path="/locations" element={<Dcards />} />
          <Route path="/bookVisit/:locationName" element={<BookingForm />} />
        </Routes>
      </div>
    </Router>
  );
};

export default App;
