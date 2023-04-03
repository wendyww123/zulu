import React, { useEffect, useState } from 'react';
import '.././App.css';

const GetCaloriesBurned = () => {
  // [reactive value, setter]
  const [activities, setActivities] = useState([]);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    setLoading(true);

    // get all
    fetch('api/v1/dailyCaloriesBurned')
      .then(response => response.json())
      .then(data => {
        setActivities(data);
        setLoading(false);
      })
  }, []); //array of dependency

  if (loading) {
    return <p>Loading...</p>;
  }

  return (
    <div className="App">
      <header className="App-header">
        <div className="App-intro">
          <h2>Get Calories Burned</h2>
          {activities.map(activity =>
            <div key={activity.id}>
              Date: {activity.date} / Calories: {activity.caloriesBurned}
            </div>
          )}
        </div>
      </header>
    </div>
  );
}

export default GetCaloriesBurned;
