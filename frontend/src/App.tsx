// import { useState } from 'react'
import { Route, Routes } from 'react-router'
import About from './components/about'
import Home from './components/home'

function App() {
  return (
    <Routes>
      <Route path='/' element={<Home /> } />
      <Route path='/about' element={<About />} />
    </Routes>
  )
}

export default App
