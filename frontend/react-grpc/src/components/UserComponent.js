import React from "react";

function User({ onFirstNameChange, onLastNameChange }) {
  return (
    <div className="main">
      <div className="user1">
        <input
          className="firstname"
          type="text"
          placeholder="First Name"
          onChange={(e) => onFirstNameChange(e.target.value)}
        />
        <input
          className="lastname"
          type="text"
          placeholder="Last Name"
          onChange={(e) => onLastNameChange(e.target.value)}
        />
      </div>
    </div>
  );
}

export default User;
