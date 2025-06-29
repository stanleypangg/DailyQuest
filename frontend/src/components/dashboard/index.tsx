import React from 'react'
import "./index.css"

const index = () => {
  return (
    <body className='m-0 p-0' style={{ fontFamily: "JetBrains Mono" }}>
        <div id='grid-container' className='grid grid-cols-[260px_1fr_1fr_1fr] grid-rows-[0.2fr_3fr] h-screen'>

            {/* Header */}
            <header id='header' className='h-[70px] bg-gray-400 flex items-center justify-between p-[0_30px_0_30px] shadow-[0_6px_7px_-3px_rgba(0,0,0,0.35)]'>
                <div> 
                </div>
            </header>

            {/* Sidebar */}
            <aside id='sidebar' className='h-full bg-gray-300 overflow-y-auto transition-all duration-[0.5s]'>
            </aside>

            {/* Main */}
            <main id='main-container' className='bg-gray-200 overflow-y-auto p-[20px_20px] '>
            </main>

        </div>
    </body>
  )
}

export default index
