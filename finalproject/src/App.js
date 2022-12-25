import logo from './logo.svg';
import axios from 'axios';
import './App.css';
import { useState } from 'react';
import { useEffect } from 'react';

function App() {
  const [companies, setCompanies] = useState([]);
  const [selectedId, setSelectedId] = useState(0);
  const [bookings, setBookings] = useState([]);
  let config = {
    headers: {
      "Access-Control-Allow-Origin": "*"
    }
  }
  function loadCompanies() {
    axios.get('http://localhost:8080/api/companies', config)
      .then((response) => {
        if (response.status === 200) {
          setCompanies(response.data);
        }
      });
  }
  const loadBookings = () => {
    if(selectedId == 0) {
      return;
    }
    axios.get('http://localhost:8080/api/bookings?companyId=' + selectedId, config)
      .then((response) => {
        if (response.status === 200) {
          setBookings(response.data)
        }
      }).catch((err)=>{
        console.log(err);
      })
  }
  useEffect(() => {
    loadCompanies()
  }, []);
  const deleteItem = (id) => {
    axios.delete("http://localhost:8080/api/companies/" + id)
      .then(() => {
        loadCompanies()
      })
      .catch((error) => {
        console.log(error)
      })


  }
  const deleteBooking = (id) => {
    axios.delete("http://localhost:8080/api/bookings/" + id)
      .then(() => {
        loadBookings()
      })
      .catch((error) => {
        console.log(error)
      })


  }
  const editItem = (item) => {
    let id = item._id
    axios.put("http://localhost:8080/api/companies/" + id, { name: item.name, description: item.description })
      .then(() => {
        loadCompanies()
      })
      .catch((error) => {
        console.log(error)
      })


  }
  const addItem = (item) => {
    const name = item.name
    const description = item.description
    console.log(item);
    axios.post("http://localhost:8080/api/companies", { name: name, description: description }, config)
      .then(() => {
        loadCompanies()
      })
      .catch(error => {
        console.log(error)
      })
  }
  const addBooking = (item) => {
    const name = item.clientName
    const description = item.description
    console.log(item);
    axios.post("http://localhost:8080/api/bookings", { clientName: name, description: description, companyId: selectedId }, config)
      .then(() => {
        loadBookings()
      })
      .catch(error => {
        console.log(error)
      })
  }
  const submitCompany = (e) => {
    e.preventDefault();
    const name = e.target.elements.name.value
    const description = e.target.elements.description.value
    addItem({ name, description });
    e.target.elements.name.value = "";
    e.target.elements.description.value = "";
  }
  const submitBooking = (e) => {
    e.preventDefault();
    const clientName = e.target.elements.clientName.value
    const description = e.target.elements.description.value
    if(selectedId == 0 || selectedId == null) {
      window.alert("Please select a company");
      return;
    }
    addBooking({ clientName, description });
    e.target.elements.clientName.value = "";
    e.target.elements.description.value = "";
  }
  
  const viewItem = (id) => {
    let viewer = document.getElementById("viewer");
    viewer.innerHTML = "";
    axios.get('http://localhost:8080/api/companies/' + id, config)
      .then((response) => {
        if (response.status === 200) {
          let item = response.data;
          setSelectedId(item.id);
          loadBookings();
          var p = document.createElement('p');
          p.innerHTML = "<b>Name: </b>" + item.name + "<br><b>Description: </b>" + item.description;
          viewer.appendChild(p);
        }
      })
    
  }
  return (
    <div className='App'>
      <h2>Company Directory</h2>
      <ul>
        {
          companies.map((c) => {
            return <li>{c.name} <br /> <button onClick={() => { viewItem(c.id) }}>Select company</button></li>
          })
        }
      </ul>
      <h3>Create new company</h3>
      <form onSubmit={submitCompany}>
        <input type="text" name="name" placeholder="Enter company name..."></input><br />
        <textarea name="description" placeholder="Enter company description..."></textarea><br />
        <button type="submit">Submit</button>
      </form>
      <h2>Company View</h2>
      <div id="viewer">
        
      </div>
      <ul>
        {
          bookings.map((c) => {
            return <li>{c.clientName} : {c.description} <button onClick={() => { deleteBooking(c.id) }}>Delete booking</button></li>
          })
        }
      </ul>
      <h3>Create booking for selected company</h3>
      <form onSubmit={submitBooking}>
        <input type="text" name="clientName" placeholder="Enter booking client's name..."></input><br />
        <textarea name="description" placeholder="Enter booking description..."></textarea><br />
        <button type="submit">Submit</button>
      </form>
    </div>
  );
}

export default App;
