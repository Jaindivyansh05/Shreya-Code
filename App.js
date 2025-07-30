import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Dcards from "./Dcards";
import BookingForm from "./BookingForm";
import Navbar from "./Navbar";
import "./App.css";

function App() {
  return (
    <Router>
      <div className="App">
        <Navbar />
        <Routes>
          <Route path="/locations" element={<Dcards />} />
          <Route path="/bookVisit/:locationName" element={<BookingForm />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
