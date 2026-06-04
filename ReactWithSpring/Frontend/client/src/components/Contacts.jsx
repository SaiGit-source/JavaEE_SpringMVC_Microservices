import React, { useState, useEffect } from 'react';
import SingleContact from './SingleContact';
import AddContact from './AddContact';

export default function Contacts() {
  const [contacts, setContacts] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/api/contacts')
      .then(response => response.json())
      .then(data => setContacts(data._embedded?.contacts || []));
  }, []);

  return (
    <div>
      <div className="row">
        <AddContact />
      </div>
      <div className="row">
        {contacts.map(contact => (
          <SingleContact key={contact.id} contact={contact} />
        ))}
      </div>
    </div>
  );
}