import React, { useState } from 'react'
import Table from './table'
import Form from './form'

const DeleteCaloriesGoal = () => {
  const usersData = [
    { userId: '1', goal: '123' },
    { userId: '2', goal: '123' },
    { userId: '3', goal: '123' },
  ]

  const [goals, setGoals] = useState(usersData)
  const addGoal = (goal) => {
    setGoals([...goals, goal])
  }

  // delete
  const deleteGoal = (id) => {
    setGoals(goals.filter((goal) => goal.userId !== id))
  }

  return (
    <div className="container">
      <h1>Create Calories Goal</h1>
      <div className="flex-row">
        <div className="flex-large">
          <h2>Add calories goal</h2>
          <Form addGoal={addGoal} />
        </div>
        <div className="flex-large">
          <h2>View calories goal</h2>
          <Table goals={goals} deleteGoal={deleteGoal} />
        </div>
      </div>
    </div>
  )
}

export default DeleteCaloriesGoal
