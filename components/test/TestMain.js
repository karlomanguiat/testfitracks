/*

This is a course requirement for CS 191 / 192 Software Engineering Courses of the Department of Computer Science, 
  College of Engineering, University of the Philippines, Diliman under the guidance of Ma. Rowena C. Solamo for the 
  1st and 2nd Semester of the academic year <2018-2019>.

This code is created by Trina B. Aguilana, Glenn Karlo D. Manguiat, and Ian N. Villanueva.

Code History:

Programmer		              Date			  Description
Glenn Karlo D. Manguiat 		02/03/18		Creation
Glenn Karlo D. Manguiat 		02/05/18 		Update on UI
Glenn Karlo D. Manguiat			02/07/18		Update on UI
Glenn Karlo D. Manguiat			02/12/18		Update on UI - Food Intake

File Creation Date: 02/03/18
Client Group: CS 192
Purpose of the Software: <FiTracks> is a web application which tracks the daily, weekly, or monthly calorie spent 
  in food and water intake for a fitter and healthier scholars of the University of the Philippines.
  
*/

import React, {Component} from 'react';
import {StyleSheet, Text, View, ScrollView, TouchableOpacity} from 'react-native';
import {createAppContainer, createStackNavigator} from 'react-navigation'
import AddWaterForm from './AddWaterForm'
import AddFoodForm from './AddFoodForm'
import movies from './test/foodindex.json'

class HomePage extends React.Component {
    render() {
      const { navigation } = this.props;
      const water_container = navigation.getParam('water_container', 'some 1 value');
      const amount_in_ml = navigation.getParam('amount_in_ml', 'some 2 value');
      const date_consumed = navigation.getParam('date_consumed', 'some 3 value');
      const time_consumed = navigation.getParam('time_consumed', 'some 4 value');

      console.log(movies.movies.id)
      console.log('water: ', water_container);
      console.log('amount: ', amount_in_ml);
      console.log('date: ', date_consumed);
      console.log('time: ', time_consumed);

      return (
        <View style={styles.container}>
        <ScrollView style={styles.scrollContainer}>
        <Text>Container: {JSON.stringify(water_container)}</Text>
        <Text>Amount in mL: {JSON.stringify(amount_in_ml)}</Text>
        <Text>{JSON.stringify(date_consumed)}</Text>
        <Text>{JSON.stringify(time_consumed)}</Text>
        </ScrollView>
      
        <TouchableOpacity 
          style={styles.addButton}
          onPress = {() => this.props.navigation.navigate('AddWater')}>
            <Text style={styles.addButtonText}>+</Text>
        </TouchableOpacity>

        </View> 
      );
    }
  }

const RootStack = createStackNavigator({
      Home: {
        screen: HomePage,
      },
      AddWater: {
        screen: AddWaterForm,
      },
      AddFood: {
        screen: AddFoodForm
      }
    },
    {
      initialRouteName: 'Home',

      defaultNavigationOptions: {
        title: 'FiTracks',
        headerStyle: {
          backgroundColor: '#DB3B3B',
        },
        headerTintColor: '#fff',
        headerTitleStyle: {
          fontWeight: 'bold',
        },
      },
    },
  );

const AppContainer = createAppContainer(RootStack);

export default class App extends React.Component {
    render() {
      return <AppContainer />;
    }
  }
  
const styles = StyleSheet.create({
    container: {
      flex: 1,
      backgroundColor: '#FFFFFF'
    },
    header: {
      backgroundColor: '#DB3B3B',
      alignItems: 'center',
      justifyContent:'center',
      borderBottomWidth: 10,
      borderBottomColor: '#ddd'
    },
    scrollContainer: {
      flex: 1,
      marginBottom: 100
    },
    headerText: {
      color: 'white',
      fontSize: 30,
      padding: 20
    },
    addButton: {
      position: 'absolute',
      zIndex: 15,
      right: 15,
      bottom: 20,
      backgroundColor: '#DB3B3B',
      width: 70,
      height: 70,
      borderRadius: 35,
      alignItems: 'center',
      justifyContent: 'center',
      elevation: 5
  },
    addButtonText: {
      color: '#fff',
      fontSize: 29
  }
});