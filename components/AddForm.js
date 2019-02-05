import React, { Component } from 'react';
import {Platform,   
    StyleSheet, 
    Text, 
    View, 
    ScrollView, 
    TouchableOpacity,
    Button 
  } from 'react-native';

import t from 'tcomb-form-native';

const Form = t.form.Form;

var ContainerType = t.enums({
  Glass: 'Glass',
  Bottle: 'Plastic Bottle',
  Container: 'Your Own Container',
  Etc: 'Others'
});
const User = t.struct({
  water_container: ContainerType,
  amount_in_ml: t.Number,
  date_consumed: t.Date,
  time_consumed: t.Date,
});

const formStyles = { ...Form.stylesheet,
  formGroup: {
        normal: {
        marginBottom: 10
    },
  },
  controlLabel: {
    normal: {
      color: 'black',
      fontSize: 20,
      marginBottom: 7,
      fontWeight: '100'
    },
    // the style applied when a validation error occours
    error: {
      color: 'red',
      fontSize: 18,
      marginBottom: 7,
      fontWeight: '600'
    }
  }
}

const options = {
  fields: {
    container: {
      error: 'Container must not be empty!'
    },
    amount_in_ml: {
      label: 'Amount in mL'
    },
    date_consumed: {
      label: 'Date Consumed',
      mode: 'date',
      config: {
        dialogMode: 'spinner',
        defaultValueText: 'Add Date of Consumption'
      },
    },
    time_consumed: {
      label: 'Time Consumed',
      mode: 'time',
      config: {
        dialogMode: 'default',
        defaultValueText: 'Add Time of Consumption'
      },
    },
  },
  stylesheet: formStyles,
};

type Props = {};
export default class AddForm extends Component<Props> {
  handleSubmit = () => {
    const value = this._form.getValue();
    console.log('value: ', value);
    }
    
  render() {
    return (
      <View style={styles.container}>
        <View style={styles.header}>
            <Text style={styles.headerText}>TEST</Text>
        </View>
        <ScrollView style={styles.scrollContainer}>
            <Form 
                ref={c => this._form = c}
                type={User} 
                options={options}
            />
            <Button style={styles.addIntakeButton}
                title="Add Intake"
                onPress={this.handleSubmit}
            />
        </ScrollView>

        <TouchableOpacity style={styles.addButton}>
            <Text style={styles.addButtonText}>+</Text>
        </TouchableOpacity>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    justifyContent: 'center',
    marginTop: 50,
    padding: 20,
    backgroundColor: '#ffffff',
  },
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
    fontSize: 25,
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
},
  addIntakeButton: {
  position: 'absolute',
  backgroundColor: '#DB3B3B',
  width: 70,
  height: 70,
  alignItems: 'center',
  justifyContent: 'center',
}
});
