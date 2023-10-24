import './App.css';
import { GreetServiceClient } from './output/GreetServiceClientPb';
import { Greeting, GreetRequest } from './output/greet_pb';
import User from './components/UserComponent';
import { SetStateAction, useState } from 'react';

function App() {
  
  const [userFirstName, setUserFirstName] = useState("");
  const [userLastName, setUserLastName] = useState("");

  const handleFirstNameChange = (value: SetStateAction<string>) => {
    setUserFirstName(value);
  };

  const handleLastNameChange = (value: SetStateAction<string>) => {
    setUserLastName(value);
  };

  const grpcCall = () => {
    
    // create our greeting object
    let greeting = new Greeting();
    greeting.setFirstName(userFirstName);
    greeting.setLastName(userLastName);
    
    // prepare the greet request
    const request = new GreetRequest();
    request.setGreeting(greeting);
     
    // create gRPC client that will call our java server
    const client = new GreetServiceClient('http://localhost:8080')
                    .greet(request, {}, (err, response) => {
                console.log({err, response});
            });
  }

return (
    <div className='App'>
      <User onFirstNameChange={handleFirstNameChange}
        onLastNameChange={handleLastNameChange} />
      <div>
         <button onClick={grpcCall}>Insert into database</button>
      </div>
    </div>
 );
}

export default App;
