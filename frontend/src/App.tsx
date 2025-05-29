// import { useState } from 'react'
import { Route, Routes } from 'react-router'
import About from './components/about'
import Home from './components/home'
import Contact from './components/contact'

function App() {
  return (
    <Routes>
      <Route path='/' element={<Home /> } />
      <Route path='/about' element={<About />} />
      <Route path='/contact' element={<Contact /> } />
    </Routes>
  )
}

export default App
