import logo from './logo.svg';
import axios from 'axios';
import './App.css';
import { useState } from 'react';

function App() {
  const [companies, setCompanies] = useState([]);
  let config = {
    headers: {
      "Access-Control-Allow-Origin": "*"
    }
  }
  axios.get("http://localhost:8080/api/companies", config)
    .then(function (response) {
      setCompanies(response.data);
      console.log(response);
    })
    .catch(function (err) {
      console.log(err);
    })
  return (
    <div className="App">
      <ul>
        {
          companies.map((c)=>{
            return <li>{c.name} : {c.description}</li>
          })
        }
      </ul>
    </div>
  );
}

export default App;
