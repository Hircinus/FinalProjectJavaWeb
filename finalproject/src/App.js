import logo from './logo.svg';
import axios from 'axios';
import './App.css';
import { useState } from 'react';
import { useEffect } from 'react';

function App() {
  const [companies, setCompanies] = useState([]);
  let config = {
    headers: {
      "Access-Control-Allow-Origin": "*"
    }
  }
  const loadTodosFromAPI = () => {
    axios.get('http://localhost:8080/api/companies', config)
      .then((response) => {
        if (response.status === 200) {
          setCompanies(response.data)
        }
      })
  }
  useEffect(() => {
    loadTodosFromAPI()
  }, []);
  const deleteItem = (id) => {
    axios.delete("http://localhost:8080/api/companies/" + id)
      .then(() => {
        loadTodosFromAPI()
      })
      .catch((error) => {
        console.log(error)
      })


  }
  const editItem = (item) => {
    let id = item._id
    axios.put("http://localhost:8080/api/companies/" + id, { name: item.name, description: item.description })
      .then(() => {
        loadTodosFromAPI()
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
        loadTodosFromAPI()
      })
      .catch(error => {
        console.log(error)
      })
  }
  const onSubmitForm = (e) => {
    e.preventDefault();
    const name = e.target.elements.name.value
    const description = e.target.elements.description.value
    addItem({ name, description });
    e.target.elements.name.value = "";
    e.target.elements.description.value = "";
  }
  return (
    <div className="App">
      <ul>
        {
          companies.map((c) => {
            return <li>{c.name} : {c.description} <button onClick={() => { deleteItem(c.id) }}>Delete</button></li>
          })
        }
      </ul>
      <form onSubmit={onSubmitForm}>
        <input type="text" name="name" placeholder="Enter company name..."></input><br />
        <input type="text" name="description" placeholder="Enter company description..."></input><br />
        <button type="submit">Submit</button>
      </form>
    </div>
  );
}

export default App;
