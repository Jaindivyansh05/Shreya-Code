import React, { useState } from "react";
import { useParams } from "react-router-dom";
import "./BookingForm.css";

const BookingForm = () => {
  const { locationName } = useParams();
  const [form, setForm] = useState({
    name: "",
    phone: "",
    date: "",
  });
  const [errors, setErrors] = useState({});

  const validate = () => {
    const errs = {};
    if (!/^[A-Za-z\s]{3,}$/.test(form.name)) {
      errs.name = "Name should have at least 3 alphabets";
    }
    if (!/^\d{10}$/.test(form.phone)) {
      errs.phone = "Phone number should be of 10 digits";
    }
    const today = new Date().toISOString().split("T")[0];
    if (form.date < today) {
      errs.date = "Date of visit should not be past date";
    }
    setErrors(errs);
    return Object.keys(errs).length === 0;
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (validate()) {
      alert("Visit Booked!");
      // Optional: send to JSON Server using fetch/axios
    }
  };

  return (
    <div className="form-container">
      <form className="booking-form" onSubmit={handleSubmit}>
        <h2>Book Visit Form</h2>

        <label>Location</label>
        <input type="text" value={locationName} readOnly />

        <label>Customer Name</label>
        <input
          type="text"
          value={form.name}
          onChange={(e) => setForm({ ...form, name: e.target.value })}
        />
        {errors.name && <p className="error">{errors.name}</p>}

        <label>Phone Number</label>
        <input
          type="tel"
          value={form.phone}
          onChange={(e) => setForm({ ...form, phone: e.target.value })}
        />
        {errors.phone && <p className="error">{errors.phone}</p>}

        <label>Visit Date</label>
        <input
          type="date"
          value={form.date}
          onChange={(e) => setForm({ ...form, date: e.target.value })}
        />
        {errors.date && <p className="error">{errors.date}</p>}

        <button type="submit">Book Visit</button>
      </form>
    </div>
  );
};

export default BookingForm;
