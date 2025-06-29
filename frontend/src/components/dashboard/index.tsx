import React from 'react'
import "./index.css"

const index = () => {
  return (
    <body className='m-0 p-0' style={{ fontFamily: "JetBrains Mono" }}>
        <div id='grid-container' className='grid grid-cols-[260px_1fr_1fr_1fr] grid-rows-[0.2fr_3fr] h-screen'>

            {/* Header */}
            <header id='header' className='h-[70px] bg-blue-400'>
            </header>

            {/* Sidebar */}
            <aside id='sidebar' className='h-max bg-gray-500'>
            </aside>

            {/* Main */}
            <main id='main-container' className='bg-orange-200'>
            </main>

        </div>
    </body>
  )
}

export default index
