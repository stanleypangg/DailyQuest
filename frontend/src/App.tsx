// import { useState } from 'react'
import { Route, Routes } from 'react-router'
import About from './components/about'
import Home from './components/home'
import Contact from './components/contact'
import Register from './components/register'
import Dashboard from './components/dashboard'

function App() {
  return (
    <Routes>
      <Route path='/' element={<Home /> } />
      <Route path='/about' element={<About />} />
      <Route path='/contact' element={<Contact /> } />
      <Route path='/register' element={<Register /> } />
      <Route path='/dashboard' element={<Dashboard /> } />
    </Routes>
  )
}

export default App
