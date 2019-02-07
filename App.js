/*

This is a course requirement for CS 191 / 192 Software Engineering Courses of the Department of Computer Science, 
  College of Engineering, University of the Philippines, Diliman under the guidance of Ma. Rowena C. Solamo for the 
  1st and 2nd Semester of the academic year <2018-2019>.

This code is created by Trina B. Aguilana, Glenn Karlo D. Manguiat, and Ian N. Villanueva.

Code History:

Programmer		              Date			  Description
Glenn Karlo D. Manguiat 		02/01/18		Creation


File Creation Date: 02/01/18
Client Group: CS 192
Purpose of the Software: <FiTracks> is a web application which tracks the daily, weekly, or monthly calorie spent 
  in food and water intake for a fitter and healthier scholars of the University of the Philippines.
  
*/

import React, {Component} from 'react';
import Main from './components/Main'


export default class App extends React.Component {
  render() {
    return (
      <Main/>
    );
  }
}
