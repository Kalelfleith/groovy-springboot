import {
  BrowserRouter,
  Routes,
  Route
} from "react-router-dom";
import Form from 'pages/Form';
import Navbar from 'components/Navbar';

function App() {
  return (
    <BrowserRouter>
      <Navbar />
      <Routes>
        <Route path="/form" element={<Form />}>
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
