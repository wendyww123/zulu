import React, { useState } from 'react'

const Form = (props) => {
  const initialFormState = { userId: '', goal: '' }
  const [goal, setGoal] = useState(initialFormState)

  const handleInputChange = (event) => {
    const { name, value } = event.target

    setGoal({ ...goal, [name]: value })
  }

  return (
    
    <form
      onSubmit={(event) => {
        event.preventDefault()
        if (!goal.userId || !goal.goal) return

        props.addGoal(goal)
        setGoal(initialFormState)
      }}
    >
      <label>User ID</label>
      <input
        type="text"
        name="userId"
        value={goal.userId}
        onChange={handleInputChange}
      />
      <label>Goal</label>
      <input
        type="text"
        name="goal"
        value={goal.goal}
        onChange={handleInputChange}
      />
      <button>Add</button>
    </form>
  )
}

export default Form;