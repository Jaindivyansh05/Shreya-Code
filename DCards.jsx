import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import "./Dcards.css"; // Optional: if you created a CSS file

const Dcards = () => {
  const [locations, setLocations] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    axios
      .get("http://localhost:4000/locations")
      .then((res) => {
        setLocations(res.data);
        console.log("Fetched locations:", res.data); // Debug line
      })
      .catch((error) => console.error("Error fetching locations:", error));
  }, []);

  return (
    <div className="cards-container">
      {locations.length === 0 ? (
        <p>Loading locations...</p>
      ) : (
        locations.map((location) => (
          <div className="card" key={location.id}>
            <img
              src="/pic.jpeg"
              alt="location icon"
              className="location-icon"
            />
            <h3>{location.name}</h3>
            <button onClick={() => navigate(⁠ /bookVisit/${location.name} ⁠)}>
              Book Now
            </button>
          </div>
        ))
      )}
    </div>
  );
};

export default Dcards;
