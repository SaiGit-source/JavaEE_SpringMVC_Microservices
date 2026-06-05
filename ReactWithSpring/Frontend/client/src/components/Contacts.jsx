import React, { useState, useEffect } from 'react';
import SingleContact from './SingleContact';
import AddContact from './AddContact';

export default function Contacts() {
  const [contacts, setContacts] = useState([]);

  useEffect(() => {
    const fetchContacts = async () => {
      try {
        const response = await fetch('http://localhost:8080/api/contacts');
        const data = await response.json();
        console.log('Full API Response:', data);
        console.log('Response keys:', Object.keys(data));
        const contactList = data._embedded?.contacts || data.contacts || data;
        console.log('Extracted contacts:', contactList);
        console.log('Is array?', Array.isArray(contactList));
        setContacts(Array.isArray(contactList) ? contactList : []);
      } catch (error) {
        console.error('Error fetching contacts:', error);
      }
    };
    fetchContacts();
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