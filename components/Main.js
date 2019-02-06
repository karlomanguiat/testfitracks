import React, {Component} from 'react';
import {StyleSheet, Text, View, ScrollView, TouchableOpacity} from 'react-native';

type Props = {};

export default class Main extends Component<Props> {
    render() {
      return (
        <View style={styles.container}>
          <View style={styles.header}>
            <Text style={styles.headerText}>FiTracks</Text>
          </View>
        <ScrollView style={styles.scrollContainer}>

        </ScrollView>
      
        <TouchableOpacity 
          style={styles.addButton}
          onPress = {() => this.props.navigation.navigate('AddFormPage')}>
            <Text style={styles.addButtonText}>+</Text>
        </TouchableOpacity>

        </View> 
      );
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
  