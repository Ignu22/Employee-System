import React from 'react'

const ViewEmployee = () => {
  return (
    <div className="container mx-auto ">
    <div className="flex max-w shadow border-b">     
      <div className="px-2 py-2">
        <div className="font-thick text-4xl tracking-wider">
          <h1>Employee Details</h1>
        </div>
        <div className="items-center justify-center h-14 w-full my-4">
          <div className="block text-gray-600 text-sm font-normal">
            First Name Last Name
            Email Id
          </div>
        </div>
      </div>
    </div>
    <div className="items-center justify-center h-14 w-full my-4">
          <label className="block text-gray-600 text-sm font-normal">
            Project Name
          </label>
          <input
            type="text"
            name="projectName"           
            className="h-10 w-96 border mt-2 px-2 py-2"></input>
            </div>
            <div className="flex shadow border-b">
        <table className="min-w-full">
          <thead className="bg-gray-50">
            <tr>
              <th className="text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                Task
              </th>
              <th className="text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                Monday
              </th>
              <th className="text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                Tuesday
              </th>
              <th className="text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                Wednesday
              </th>
              <th className="text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                Thursday
              </th>
              <th className="text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                Friday
              </th>
              <th className="text-right font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                Actions
              </th>
            </tr>
            <tbody className="item-centre font-medium bg-white tracking-wider py-3 px-6">
              <tr className='text-centre font-medium text-gray-500 tracking-wider py-3 px-6'>Coding</tr>
              <tr>Learning</tr> 

            </tbody>
          </thead>

        </table>
      </div>
    </div>
  )
}

export default ViewEmployee