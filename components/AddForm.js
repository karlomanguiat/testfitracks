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
      marginBottom: 0,
      marginTop: 2,
      height: 100,
      width: 350,
      padding: 0,
      justifyContent:'center',
    },

    error: {
      marginBottom: 0,
      height: 100,
      width: 350,
      padding: 0,
      justifyContent:'center',
    },
  },
  controlLabel: {
    normal: {
      color: 'black',
      fontSize: 18,
      marginBottom: 4,
      fontWeight: '400'
    },
    // the style applied when a validation error occours
    error: {
      color: '#DB3B3B',
      fontSize: 18,
      marginBottom: 4,
      fontWeight: '400'
    }
  }
}

const options = {
  fields: {
    water_container: {
      label: 'Water Container',
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
            <Text style={styles.headerText}>FiTRACKS</Text>
        </View>
        <ScrollView style={styles.scrollContainer}>
          <View style={styles.containerscreen}>
            <View style={styles.form_container}>
              <Form 
                ref={c => this._form = c}
                type={User} 
                options={options}
              />

              <TouchableOpacity
                style={styles.submitbutton}
                onPress={this.handleSubmit}
              >
                <Text style={styles.submitbuttontext}> Submit </Text>
              </TouchableOpacity>
            </View>
          </View>
        </ScrollView>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#FFFFFF',
  },
  containerscreen: {
    flex: 1,
    backgroundColor: '#FFFFFF',
    alignItems: 'center',
    marginBottom: 5,
    marginTop: 10,
    borderColor: '#cccccc',

  },
  form_container: {
    flex: 1,
    width: 390,
    alignItems: 'center',
    backgroundColor: '#FFFFFF',
    borderRadius: 4,
    borderColor: '#cccccc', // <= relevant style here
    borderWidth: 1,
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
    marginBottom: 0
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
  },
  submitbutton: {
    width: 350,
    alignItems: 'center',
    backgroundColor: '#0EA3F2',
    padding: 10,
    marginBottom: 20,
    borderRadius: 5
  },
  submitbuttontext: {
    color: '#fff',
    fontSize: 18
  },
});
