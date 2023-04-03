import React from 'react'

const Table = (props) => (
  <table>
    <thead>
      <tr>
        <th>User ID</th>
        <th>Calories Goal</th>
      </tr>
    </thead>
    <tbody>
      {props.goals.length > 0 ? (
        props.goals.map((goal) => (
          <tr key={goal.userId}>
            <td>{goal.userId}</td>
            <td>{goal.goal}</td>
            <td>
              <button className="button muted-button">Edit</button>
              <button
                onClick={() => props.deleteGoal(goal.userId)}
                className="button muted-button"
              >
                Delete
              </button>
            </td>
          </tr>
        ))
      ) : (
        <tr>
          <td colSpan={3}>No users</td>
        </tr>
      )}
    </tbody>
  </table>
)

export default Table
